package xmlPo;


import java.io.File;

import javax.xml.bind.*;

public class ExampleUnMarshall {



	

		private static final String NOM_FITXER = "exemple.xml";
		private static final String NOM_FITXERE = "exemple2.xml";
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Empleat currito = new Empleat(133,"home","Xavi","Big Boss",40,"12345");
			Empleat currito2 = new Empleat();
			
			
			
			
			
			try{
			
				currito2 = XmlAObjecte();
				System.out.println(currito2);
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		private static Empleat XmlAObjecte() {
			// TODO Auto-generated method stub
			try {
				JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
				Unmarshaller um = contexte.createUnmarshaller();
				Empleat currante = (Empleat) um.unmarshal(new File(NOM_FITXERE));
				return currante;
			} catch (JAXBException j) {
				// TODO Auto-generated catch block
				j.printStackTrace();
			}
			return null;
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

