package xmlPo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.*;

public class ExempleJAXB {

	private static final String NOM_FITXER = "exemple.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleat currito = new Empleat(133,"home","Xavi","Big Boss",40,"12345");
		
		Empleat currito2 = new Empleat(133,"home","jordi","Big Boss",40,"12345");
		Empleat currito3 = new Empleat(133,"home","ramon","Big Boss",40,"12345");
		
		try{
			//objecteAXml(currito);
			//ArrayList<Empleat> myStaff = new ArrayList <Empleat>();
			Staff myStaff = new Staff();
			myStaff.add(currito);
			myStaff.add(currito2);
			myStaff.add(currito3);
	
			marshalLlista(myStaff, new File("llistaEmpleats.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void marshalLlista(Staff myStaff, File file) {
		// TODO Auto-generated method stub
		try {
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(file));
			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(myStaff, writer);
			writer.close();
			
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}


	private static void objecteAXml(Empleat currante) {
	
		try {
		JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
		Marshaller m = contexte.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//m.marshal(currante, new File(NOM_FITXER));
		m.marshal(currante,System.out);
		} catch (JAXBException e){
			e.printStackTrace();
		}
}
	
}
