/* ========================================================================
 * Copyright 2014 g9
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 g9

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.g9.seccion.master.persistence.api;

import co.edu.uniandes.csw.g9.seccion.master.persistence.entity.Seccioninscritos_seccionEntity;
import co.edu.uniandes.csw.g9.estudiante.logic.dto.EstudianteDTO;
import co.edu.uniandes.csw.g9.seccion.master.persistence.entity.SeccionenEspera_seccionEntity;
import co.edu.uniandes.csw.g9.estudiante.logic.dto.EstudianteDTO;
import co.edu.uniandes.csw.g9.seccion.master.logic.dto.SeccionMasterDTO;
import java.util.List;

public interface _ISeccionMasterPersistence {

	public SeccionMasterDTO getSeccion(Long seccionId);
	
	
    public Seccioninscritos_seccionEntity createSeccioninscritos_seccionEntity(Seccioninscritos_seccionEntity entity);
    public void deleteSeccioninscritos_seccionEntity(Long seccionId, Long inscritos_seccionId);
    public List<EstudianteDTO> getSeccioninscritos_seccionEntityList(Long seccionId);
    public SeccionenEspera_seccionEntity createSeccionenEspera_seccionEntity(SeccionenEspera_seccionEntity entity);
    public void deleteSeccionenEspera_seccionEntity(Long seccionId, Long enEspera_seccionId);
    public List<EstudianteDTO> getSeccionenEspera_seccionEntityList(Long seccionId);
   
  
}
