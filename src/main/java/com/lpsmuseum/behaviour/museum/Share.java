package com.lpsmuseum.behaviour.museum;

import java.io.IOException;
import java.util.ArrayList;

import com.dropbox.core.DbxException;
import com.lpsmuseum.dto.Annotation;

public interface Share {
	
	void shareAnnotations(ArrayList<Annotation> annotations) throws IOException, DbxException;
	
}
