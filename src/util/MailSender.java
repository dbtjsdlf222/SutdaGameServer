package util;

import vo.PlayerVO;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;

public class MailSender implements Runnable {
	
		private String address;
		private PlayerVO thisPlayerVO;
	
		public MailSender(String address, PlayerVO vo) {
			this.address=address;
			thisPlayerVO = vo;
		}
	
		@Override
		public void run() {
			
		int code=0;
		try {
			// 메일 환경 변수 설정입니다.
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.gmail.com");			// 메일 호스트 주소를 설정합니다.
			props.put("mail.smtp.auth", "true");			// ID, Password 설정이 필요합니다.
			props.put("mail.smtp.port", "465");
			
			// ssl 설정
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.quitwait", "false");
			
			// id와 password를 설정하고 session을 생성합니다.
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("sutdaonline", "rllepxesjimaknqd");
				}
			});
			
			// 메일 메시지를 만들기 위한 클래스를 생성합니다.
			MimeMessage message = new MimeMessage(session);
			message.setFrom(getAddress("sutdaonline@gmail.com"));			// 송신자 설정
			message.addRecipients(Message.RecipientType.TO, getAddresses(address));			// 수신자 설정
			message.setSubject("섯다 가입 인증 메일입니다.");	// 메일 제목을 설정합니다.
			message.setContent(new MimeMultipart());			// 메일 내용을 설정을 위한 클래스를 설정합니다.
			
			Multipart mp = (Multipart) message.getContent();
			StringBuffer sb = new StringBuffer();

			code = new Random().nextInt(4589362) + 49311; // 이메일로 받는 인증코드 부분 (난수)

			sb.append("<h1>섯다 가입인증 메일입니다.</h1>");
			sb.append("<hr>");
			sb.append("<h3>환영합니다.</h3>");
			sb.append("<h4>가입 인증 번호는 [<h1>" + code + "</h1>] 입니다.</h3>");
			sb.append("<hr>");

			mp.addBodyPart(getContents("<html><head></head>" + sb + "</body></html>"));
			Transport.send(message); // 메일을 보냅니다.
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		Packing.sender(thisPlayerVO.getPwSocket(), Protocol.SEND_MAIL_CODE, "true");
		thisPlayerVO.setIp(code+"");
	}

	// html 형식으로 설정
	private BodyPart getContents(String html) throws MessagingException {
		BodyPart mbp = new MimeBodyPart();
		mbp.setContent(html, "text/html; charset=utf-8");
		return mbp;
	}

	// String으로 된 메일 주소를 Address 클래스로 변환
	private Address getAddress(String address) throws AddressException {
		return new InternetAddress(address);
	}

	// String으로 된 복수의 메일 주소를 콤마(,)의 구분으로 Address array형태로 변환
	private Address[] getAddresses(String addresses) throws AddressException {
		String[] array = addresses.split(",");
		Address[] ret = new Address[array.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = getAddress(array[i]);
		}
		return ret;
	}

}