package com.myclass.main;

import java.awt.Color;
import java.awt.EventQueue;

import com.myclass.gui.Application;
import com.myclass.gui.TaiKhoanFrame;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiKhoanFrame taiKhoanFrame = new TaiKhoanFrame();
					taiKhoanFrame.setUndecorated(true);
					taiKhoanFrame.setLocationRelativeTo(null);
					taiKhoanFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
