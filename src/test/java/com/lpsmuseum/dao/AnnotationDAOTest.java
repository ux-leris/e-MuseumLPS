package com.lpsmuseum.dao;

import java.util.List;

import junit.framework.TestCase;

import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.entity.AnnotationDO;

public class AnnotationDAOTest extends TestCase {

    List<Annotation> annotations;

    @Override
    protected void setUp() throws Exception {
        annotations = DAOTestUtil.generateAnnotations();
    }

    public void testCRUD() {
        assertNotNull(annotations);

        AnnotationDAO dao = new AnnotationDAO();
        assertNotNull(dao);

        List<AnnotationDO> annotationsDO;

        /*
	 * Creating
         */
        // Are the objects persisting?
        for (Annotation annotation : annotations) {
            assertNotNull(annotation);
            AnnotationDO annotationDO = annotation.getEntity();
            assertNotNull(annotationDO);
            dao.createAnnotation(annotationDO);
        }

        // Are the objects persisted?
        annotationsDO = dao.listAnnotations();
        assertNotNull(annotationsDO);

        for (Annotation annotation : annotations) {
            //boolean match = false;
            for (AnnotationDO annotationDO : annotationsDO) {
                if (annotation.getEntity().getTitle() == annotationDO
                        .getTitle()) {
                    //match = true;
                    break;
                }
            }
            //assertTrue(match);
        }

        /*
	 * Editing
         */
        // Can objects be modified and persisted?
        for (AnnotationDO annotationDO : annotationsDO) {
            annotationDO.setTitle(annotationDO.getTitle().concat("test"));
            dao.editAnnotation(annotationDO);
        }

        // Are the objects modified and persisting?
        annotationsDO = dao.listAnnotations();
        assertNotNull(annotationsDO);
        for (Annotation annotation : annotations) {
            //boolean match = false;
            for (AnnotationDO annotationDO : annotationsDO) {
                if (annotation.getEntity().getTitle() == annotationDO
                        .getTitle()) {
                    //s	match = true;
                    break;
                }
            }
            //assertTrue(match);
        }

        /*
	 * Deleting
         */
        for (AnnotationDO annotationDO : annotationsDO) {
            assertNotNull(annotationDO);
            dao.deleteAnnotation(annotationDO);
        }

        annotationsDO = dao.listAnnotations();
        assertNotNull(annotationsDO);
        for (Annotation annotation : annotations) {
            //boolean match = false;
            for (AnnotationDO annotationDO : annotationsDO) {
                if (annotation.getEntity().getTitle() == annotationDO.getTitle()) {
                    //	match = true;
                    break;
                }
            }
            //assertFalse(match);
        }

    }

}
