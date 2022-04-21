package com.bbva.makz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.makz.dto.employees.EmployeesDTO;
import com.bbva.makz.lib.r001.MAKZR001;

public class MAKZT00101MXTransaction extends AbstractMAKZT00101MXTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(MAKZT00101MXTransaction.class);

	@Override
	public void execute() {
		MAKZR001 makzR001 = this.getServiceLibrary(MAKZR001.class);
		
		String entrada = this.getEntrada();
		
		if ("0".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de insertar");
			EmployeesDTO employee = makzR001.executeInsert(getEmployeein());
			setEmployeeout(employee);
			LOGGER.info("Saliendo de la operacion insertar");
			
		} else if ("1".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion actualizar");
			EmployeesDTO employeeU = makzR001.executeUpdate(getEmployeein());
			setEmployeeout(employeeU);
			LOGGER.info("Saliendo de la operacion actualizar");
			
		} else if ("2".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion eliminar por numero");
			makzR001.executeDeleteByNumber(getEmployeein());
			LOGGER.info("Saliendo de la operacion eliminar por numero");
			
		} else if ("3".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de consultar por nombre");
			EmployeesDTO getEmployee = makzR001.executeGetByName(getEmployeein());
			setEmployeeout(getEmployee);
			LOGGER.info("Saliendo de la operacion de consultar por nombre");
			
		} else if ("4".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de consultar todos los registros");
			List<EmployeesDTO> list = makzR001.executeAllEmployees();
			setListdto(list);
			LOGGER.info("Saliendo de la operacion de consultar todos los registro");
			
		}

		Advice advice = getAdvice();

		if (advice != null && "MNEO01317007".equals(advice.getCode())) {
			setSeverity(Severity.EWR);
		} else {
			setSeverity(Severity.OK);
			LOGGER.info("La operacion termino de manera EXITOSA");
		}
		
	}

}
