package com.haohanyh.hamos;

import com.nle.demo.Adam4150Controller;
import com.nle.serialport.SerialPortManager;
import com.nle.serialport.exception.SerialPortException;

import gnu.io.SerialPort;

public class TestLed {

	public static void main(String[] args) throws SerialPortException {

		//��ȡ���ڹ������
		SerialPortManager manager = new SerialPortManager();

		//�򿪶˿�,COM201 9600,�˿ںźͲ����ʺͷ������һ�£�
		SerialPort serialPort = manager.openPort("COM201", 9600);

		//��ʼ���������豸ADAM4150,����Ҳ����4150��!
		Adam4150Controller controller = new Adam4150Controller(manager, serialPort);

		//����4150 DO0��
		controller.openLed("01 05 00 10 FF 00 8D FF");

		//����������к�����10s��ʱ
		ThreadRun(10000);

		//����4150 DO0��
		controller.openLed("01 05 00 10 00 00 CC 0F");

		manager.closePort(serialPort);
	}

	public static void ThreadRun(int i) {
		//���߳�����һ��ʱ��
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
