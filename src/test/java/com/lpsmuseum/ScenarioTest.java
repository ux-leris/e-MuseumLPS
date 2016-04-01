package com.lpsmuseum;

import java.util.Calendar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import com.lpsmuseum.service.builders.ScenarioBuilder;

public class ScenarioTest extends TestCase {

    MuseologicalObject obj;
    Text txt;

    public ScenarioTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(ScenarioTest.class);
    }

    public void setUp() {
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_MONTH, -1);
        obj = new MuseologicalObjectBuilder()
                .build("TestObject", c1);
        txt = (Text) new MuseologicalObjectBuilder()
                .build("TestText", c1, new Text());
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -1);
        Image img = new Image();
        img.setUrlAddress("http://www.image.com/");
        img = (Image) new MuseologicalObjectBuilder()
                .build("TestImage", date, img);
    }

    public void testBuilder() {
        Scenario scenario;
        try {
            Theme theme = new Theme();
            theme.setTitle("Tema teste 1");
            theme.setDescription("Tema teste de um cenário de testes.");

            scenario = new ScenarioBuilder()
                    .withObject(obj)
                    .withObject(txt)
                    .withTheme(theme)
                    .build("Scenario1");
            assertNotNull(scenario);
            assertTrue(scenario.getObjects().size() == 2);
            assertTrue(scenario.getObjects().get(0) instanceof MuseologicalObject);
            assertTrue(scenario.getObjects().get(1) instanceof Text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
