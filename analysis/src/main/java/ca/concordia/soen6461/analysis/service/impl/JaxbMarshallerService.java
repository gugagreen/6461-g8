package ca.concordia.soen6461.analysis.service.impl;

import java.io.Reader;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ca.concordia.soen6461.analysis.service.MarshallerService;

public class JaxbMarshallerService<T> implements MarshallerService<T> {

	@Override
	public void marshall(T object, Writer writer) {
		try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new InternalError("Error during game marshalling");
        }
		
	}

	@Override
	public T unmarshall(Class<T> clazz, Reader reader) {
		try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T object = (T) unmarshaller.unmarshal(reader);
            return object;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new InternalError("Error during game unmarshalling");
        }
	}

}
