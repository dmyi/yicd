package 哈希表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 * @date   2020年11月10日 下午2:00:43
 * @author cc
 *
 */
public class _706_设计哈希映射 {
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//
//    }
//    
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//
//    }
//    
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//
//    }
//    
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//
//    }
    
    class Pair<K, V> {
    	public K key;
    	public V value;
    	public Pair(K key, V value) {
    		this.key = key;
    		this.value = value;
    	}
    }
    
    class Bucket {
    	private List<Pair<Integer, Integer>> bucket;
    	public Bucket() {
    		this.bucket = new LinkedList<Pair<Integer,Integer>>();
    	}
    	
    	public Integer get(Integer key) {
    		for(Pair<Integer, Integer> pair : this.bucket) {
    			if(pair.key.equals(key)) {
    				return pair.value;
    			}
    		}  		
    		return -1;
    	}
    	
    	public void update(Integer key, Integer value) {
    		boolean flag = false;
    		for(Pair<Integer, Integer> pair : this.bucket) {
    			if(pair.key.equals(key)) {
    				pair.value = value;
    				flag = true;
    			}
    		}
    		if(!flag) {
    			this.bucket.add(new Pair<Integer, Integer>(key, value));
    		}
    	}
    	
    	public void remove(Integer key) {
    		for(Pair<Integer, Integer> pair : this.bucket) {
    			if(pair.key.equals(key)) {
    				this.bucket.remove(pair);
    				break;
    			}
    		}
    	}
    }

	class MyHashMap {
	  private int key_space;
	  private List<Bucket> hash_table;

	  /** Initialize your data structure here. */
	  public MyHashMap() {
		  this.key_space = 2069;
		  this.hash_table = new ArrayList<Bucket>();
		  for (int i = 0; i < this.key_space; i++) {
			this.hash_table.add(new Bucket());
		  }
	  }
	  
	  /** value will always be non-negative. */
	  public void put(int key, int value) {
		  int hash_key = key % this.key_space;
		  this.hash_table.get(hash_key).update(key, value);
	  }

	  /**
	   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
	   * for the key
	   */
	  public int get(int key) {
	    int hash_key = key % this.key_space;
	    return this.hash_table.get(hash_key).get(key);
	  }

	  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	  public void remove(int key) {
	    int hash_key = key % this.key_space;
	    this.hash_table.get(hash_key).remove(key);
	  }
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
	 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
	 */

}
