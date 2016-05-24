<?php
	if(!defined('ACCESS')) exit;

	class Application{

		public static function setInit()
		{
			// 定义系统常量
			define('ROOT_DIR', str_replace('\\', '/', dirname(__DIR__)));
			define('CORE_DIR', ROOT_DIR.'/Core');
			define('ACTION_DIR', ROOT_DIR.'/Action');
			define('MODEL_DIR', ROOT_DIR.'/Model');
			define('VIEW_DIR', ROOT_DIR.'/View');
			define('CONFIG_DIR', ROOT_DIR.'/Config');

			// 设定字符集
			header('Content-type:text/html; charset = utf-8');

			// 设置错误输出
			@ini_set('display_errors', 1);

			error_reporting(E_ALL);

			// 开启sesssion
			@session_start();

			// 引入配置文件
			$GLOBALS['config'] = include CONFIG_DIR.'/Config.php';

		}

		// 自动加载
		public static function loadAction($class)
		{

			if(is_file(ACTION_DIR."/$class.class.php"))
			{
				include ACTION_DIR."/$class.class.php";
			}
		}

		public static function loadModel($class)
		{

			if(is_file(MODEL_DIR."/$class.class.php"))
			{
				include MODEL_DIR."/$class.class.php";
			}
		}

		public static function loadCore($class)
		{

			if(is_file(CORE_DIR."/$class.class.php"))
			{
				include CORE_DIR."/$class.class.php";
			}
		}

		private static function setAutoload()
		{
			spl_autoload_register(array('Application','loadAction'));
			spl_autoload_register(array('Application','loadModel'));
			spl_autoload_register(array('Application','loadCore'));
		}

		// 分发
		private static function setDispatch()
		{
			// 设置url
			$module = isset($_REQUEST['module']) ? strtolower($_REQUEST['module']) : 'Privilege';
			$action = isset($_REQUEST['action']) ? strtolower($_REQUEST['action']) : 'login';

			$module = ucfirst($module);

			// 权限和分发
			if(!($module == 'Privilege' && ($action == 'login' || $action == 'signin')) && !isset($_SESSION['user']))
			{
				// 跳转登陆页面
				header('Location:index.php');
			}else{
				// 分发
				$module = $module.'Action';

				$module = new $module();
				$module->$action();
			}

		}

		// 主函数
		public static function run()
		{
			// 1 初始化
			self::setInit();
			// 2 自动加载
			self::setAutoload();
			// 3 分发
			self::setDispatch();
		}
	}



?>