package by.epam.rest.model.factory;

import by.epam.rest.model.iface.ReservationDAO;
import by.epam.rest.model.impl.ReservationImplXml;

public class ReservationImplFactory {
	public static ReservationDAO getImplementation() {
		return new ReservationImplXml();
	}
}
