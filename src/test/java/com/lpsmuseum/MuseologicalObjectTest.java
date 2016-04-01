package com.lpsmuseum;

import java.util.Calendar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;

public class MuseologicalObjectTest extends TestCase {

    public MuseologicalObjectTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(MuseologicalObjectTest.class);
    }

    public void testBuilder() {
        String name = "TestObject";
        MuseologicalObject obj = new MuseologicalObjectBuilder()
                .build(name, Calendar.getInstance());
        assertNotNull(obj);
        assertEquals(name, obj.getName());
    }

    public void testExtension() {
        String url = "http://www.test.com/";
        MuseologicalObject txt = new MuseologicalObjectBuilder()
                .build("TestText", Calendar.getInstance(), new Text());
        Image img = new Image();
        img.setUrlAddress(url);
        img = (Image) new MuseologicalObjectBuilder()
                .build("TestImg", Calendar.getInstance(), img);
        assertNotNull(txt);
        assertTrue(txt instanceof Text);
        assertEquals(url, img.getUrlAddress());
    }

    public void testEdition() {
        Calendar c = Calendar.getInstance();
        MuseologicalObject obj = new MuseologicalObjectBuilder()
                .build("TesTObj", c);
        c.add(Calendar.DAY_OF_MONTH, -1);
        obj.setDate(c);
        obj.setName("TestObj");
        MuseologicalObjectService svc = new MuseologicalObjectService();
        svc.editObject(obj);
    }

    /*public void testAnnotation() {
        String title = "Annotation Object";
        Annotation an = new Annotation();
        an.setTitle(title);
        an.setAuthor("LPS Museum");
        an.setContent("Testing annotation creation for Object");
        MuseologicalObject obj = new MuseologicalObjectBuilder()
                .withAnnotation(an)
                .build("ObjAnnotation", Calendar.getInstance());

        an = new AnnotationService().findByTitle(an.getTitle());

        assertNotNull(obj);
        assertNotNull(an);
        assertEquals(title, an.getTitle());
    }*/
}
