package com.haohanyh.hamos;

import com.nle.demo.Adam4150Controller;
import com.nle.serialport.SerialPortManager;
import com.nle.serialport.exception.SerialPortException;

import gnu.io.SerialPort;

public class TestLed {

	public static void main(String[] args) throws SerialPortException {

		//获取串口管理对象
		SerialPortManager manager = new SerialPortManager();

		//打开端口,COM201 9600,端口号和波特率和仿真软件一致！
		SerialPort serialPort = manager.openPort("COM201", 9600);

		//初始化数字量设备ADAM4150,仿真也是用4150的!
		Adam4150Controller controller = new Adam4150Controller(manager, serialPort);

		//控制4150 DO0开
		controller.openLed("01 05 00 10 FF 00 8D FF");

		//浩瀚银河自研函数，10s延时
		ThreadRun(10000);

		//控制4150 DO0关
		controller.openLed("01 05 00 10 00 00 CC 0F");

		manager.closePort(serialPort);
	}

	public static void ThreadRun(int i) {
		//让线程休眠一段时间
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
