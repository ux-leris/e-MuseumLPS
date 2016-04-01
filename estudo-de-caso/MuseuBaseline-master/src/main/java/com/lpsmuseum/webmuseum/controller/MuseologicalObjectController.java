package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MuseologicalObjectController {

	private MuseologicalObjectService service = new MuseologicalObjectService();

	@RequestMapping("object/create")
	public ModelAndView form() {
		return new ModelAndView("object/form");
	}
        
        @RequestMapping("object/hello")
	public ModelAndView index() {
            ModelAndView mv =  new ModelAndView("object/index");
            List<MuseologicalObject> objects = service.listObjects();
            System.out.println("objects " + objects.get(0).getText());
            mv.addObject("list", objects);
            // TODO Distinção entre tipos, objeto, imagem e texto
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            mv.addObject("format", sdf);
            return mv;
	}
        
        @RequestMapping("object/email")
	public String email(String nome, String pergunta) {
                System.out.println("send email");
                final String username = "monisribeiro@gmail.com";
		final String password = "sededesdecedo";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("monisribeiro@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("monisribeiro@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
                return null;
	}
        
        @RequestMapping("object/sobre")
	public ModelAndView sobre() {
            return new ModelAndView("object/sobre");
	}
        
        @RequestMapping("object/perguntas")
	public ModelAndView perguntas() {
            return new ModelAndView("object/perguntas");
	}
        
         @RequestMapping("object/galeria")
	public ModelAndView galeria() {
		ModelAndView mv =  new ModelAndView("object/galeria");
                List<MuseologicalObject> objects = service.listObjects();
                System.out.println("objects " + objects.get(0).getText());
		mv.addObject("list", objects);
                // TODO Distinção entre tipos, objeto, imagem e texto
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
        
          @RequestMapping("object/tour")
	public ModelAndView tour() {
		ModelAndView mv =  new ModelAndView("object/galeria");
                List<MuseologicalObject> objects = service.listObjects();
                System.out.println("objects " + objects.get(0).getText());
		mv.addObject("list", objects);
                // TODO Distinção entre tipos, objeto, imagem e texto
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
        
        @RequestMapping("object/desafios")
	public ModelAndView desafios() {
		ModelAndView mv =  new ModelAndView("object/galeria");
                List<MuseologicalObject> objects = service.listObjects();
                System.out.println("objects " + objects.get(0).getText());
		mv.addObject("list", objects);
                // TODO Distinção entre tipos, objeto, imagem e texto
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
        
         @RequestMapping("object/search")
	public ModelAndView search(String search) {
                System.out.println("search " + search);
		ModelAndView mv =  new ModelAndView("object/galeria");
                List<MuseologicalObject> objects = service.listObjectsSearch(search);
                System.out.println("objects " + objects);
		mv.addObject("list", objects);
                // TODO Distinção entre tipos, objeto, imagem e texto
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
        
	@RequestMapping("object")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("object/list");
		List<MuseologicalObject> objects = service.listObjects();
		mv.addObject("list", objects);
                // TODO Distinção entre tipos, objeto, imagem e texto
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
	
	@RequestMapping("object/add")
	public ModelAndView addObject(String name, String date, String url) {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		ModelAndView mv;
		MuseologicalObject obj;

		try {
			c.setTime(sdf.parse(date));
			if (url.isEmpty()) {
				obj = (Text) new MuseologicalObjectBuilder().build(name, c, new Text());
			} else {
				Image img = new Image();
				img.setUrlAddress(url);
				obj = (Image) new MuseologicalObjectBuilder().build(name, c, img);
			}
			mv = new ModelAndView("object/created");
			mv.addObject("object", obj);
			mv.addObject("format", sdf);
		} catch (ParseException e) {
			e.printStackTrace();
			mv = new ModelAndView("object/error");
		}
		return mv;
	}
	
	@RequestMapping("object/edit")
	public ModelAndView editObject(Long id) {
		ModelAndView mv = new ModelAndView("object/edit");
		mv.addObject("object", service.findById(id));
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
	
	@RequestMapping("object/delete")
	public String delete(Long id){
		// NOTE Não trabalhamos com anotações, se preocupar com elas não é desnecessário?
		AnnotationService annotationService = new AnnotationService();
		ArrayList<Annotation> annotations = annotationService.listByObject(id);
		if (annotations != null && annotations.size() > 0)
			for (Annotation a : annotations)
				annotationService.deleteAnnotation(a.getId());
		
		new MuseologicalObjectService().deleteObject(id);
		return "redirect:/object";
	}
	
	@RequestMapping("object/update")
	public String update(Long id, String name, String date) {
		MuseologicalObjectService service = new MuseologicalObjectService();
		MuseologicalObject object = service.findById(id);
		object.setName(name);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			c.setTime(sdf.parse(date));
		} catch (ParseException e) {
			return "redirect:/object/error";
		}
		object.setDate(c);
		service.editObject(object);		
		return "redirect:/object";
	}
        
        
}
