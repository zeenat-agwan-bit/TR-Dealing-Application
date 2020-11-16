package com.zee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.dao.TransporterDAO;
import com.zee.domain.Transporter;
@Service
public class TransporterServiceImpl implements TransporterService {
	
	@Autowired
	private TransporterDAO dao;

	public Transporter verifyUserTransporter(Transporter transporter) {

		return dao.verifyTransporter(transporter);
	}

	public void addTransporter(Transporter transporter) {
		dao.saveTransporter(transporter);

	}

	public void changeTransporter(Transporter transpoter) {

		dao.updateTransporter(transpoter);
	}

	public Transporter searchTransById(String email) {

		return dao.getTransById(email);
	}

	public void removeTrans(String email) {
		dao.deleteTrans(email);

	}

}
