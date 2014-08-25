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

package co.edu.uniandes.csw.g9.curso.master.persistence;
import co.edu.uniandes.csw.g9.seccion.logic.dto.SeccionDTO;
import co.edu.uniandes.csw.g9.curso.master.persistence.entity.Cursoseccion_cursoEntity;
import co.edu.uniandes.csw.g9.seccion.persistence.converter.SeccionConverter;
import co.edu.uniandes.csw.g9.curso.logic.dto.CursoDTO;
import co.edu.uniandes.csw.g9.curso.master.logic.dto.CursoMasterDTO;
import co.edu.uniandes.csw.g9.curso.master.persistence.api._ICursoMasterPersistence;
import co.edu.uniandes.csw.g9.curso.persistence.api.ICursoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _CursoMasterPersistence implements _ICursoMasterPersistence {

  	@PersistenceContext(unitName="prePPU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected ICursoPersistence cursoPersistence;  

    public CursoMasterDTO getCurso(Long cursoId) {
        CursoMasterDTO cursoMasterDTO = new CursoMasterDTO();
        CursoDTO curso = cursoPersistence.getCurso(cursoId);
        cursoMasterDTO.setCursoEntity(curso);
        cursoMasterDTO.setListseccion_curso(getCursoseccion_cursoEntityList(cursoId));
        return cursoMasterDTO;
    }

    public Cursoseccion_cursoEntity createCursoseccion_cursoEntity(Cursoseccion_cursoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteCursoseccion_cursoEntity(Long cursoId, Long seccion_cursoId) {
        Query q = entityManager.createNamedQuery("Cursoseccion_cursoEntity.deleteCursoseccion_cursoEntity");
        q.setParameter("cursoId", cursoId);
        q.setParameter("seccion_cursoId", seccion_cursoId);
        q.executeUpdate();
    }

    public List<SeccionDTO> getCursoseccion_cursoEntityList(Long cursoId) {
        ArrayList<SeccionDTO> resp = new ArrayList<SeccionDTO>();
        Query q = entityManager.createNamedQuery("Cursoseccion_cursoEntity.getByMasterId");
        q.setParameter("cursoId",cursoId);
        List<Cursoseccion_cursoEntity> qResult =  q.getResultList();
        for (Cursoseccion_cursoEntity entity : qResult) { 
            if(entity.getSeccion_cursoIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(SeccionConverter.entity2PersistenceDTO(entity.getSeccion_cursoIdEntity()));
        }
        return resp;
    }

}
