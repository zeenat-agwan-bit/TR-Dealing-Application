package com.zee;

public interface TransporterService {

		public Transporter verifyUserTransporter(Transporter transporter);
		public void addTransporter(Transporter transporter);
		public void changeTransporter(Transporter transpoter);
		public Transporter searchTransById(String email);
		public void removeTrans(String email);
}
