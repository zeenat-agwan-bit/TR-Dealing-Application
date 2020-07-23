package com.zee;

public interface TransporterDAO {
public Transporter verifyTransporter(Transporter transporter);
public void saveTransporter(Transporter transporter);
public void updateTransporter(Transporter transpoter);
public Transporter getTransById(String email);
public void deleteTrans(String email);

}
