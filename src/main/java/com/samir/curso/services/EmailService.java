package com.samir.curso.services;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.samir.curso.domain.Cliente;
import com.samir.curso.domain.Pedido;

@Service
public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
