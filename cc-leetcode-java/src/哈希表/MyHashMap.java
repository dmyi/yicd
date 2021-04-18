package 哈希表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap { 
	class Pair<K, V> {
		public K key;
		public V value;
		public Pair(K key, V value) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value = value;
		}
	}
	
	class Bucket {
		private List<Pair<Integer, Integer>> bucket;
		public Bucket() {
			this.bucket = new LinkedList<Pair<Integer,Integer>>();
		}
		
		public Integer get(int key) {
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
					flag = true;
					pair.value = value;					
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
	
	private int key_space;
	private List<Bucket> hash_table;
	public MyHashMap() {
		// TODO Auto-generated constructor stub
		this.key_space = 2069;
		// 链表的元素类型是Bucket
		this.hash_table = new ArrayList<Bucket>();
		for (int i = 0; i < this.key_space; i++) {
			this.hash_table.add(new Bucket());
		}	
	}
	
	public int get(int key) {
		int hash_key = key % key_space;
		return this.hash_table.get(hash_key).get(key);
	}
	
	public void put(int key, int value) {
		int hash_key = key % key_space;
		this.hash_table.get(hash_key).update(key, value);
	}
	
	public void remove(int key) {
		int hash_key = key % key_space;
		this.hash_table.get(hash_key).remove(key);
	}

}

