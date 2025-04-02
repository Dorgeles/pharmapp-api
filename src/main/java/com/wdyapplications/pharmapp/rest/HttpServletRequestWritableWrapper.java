package com.wdyapplications.pharmapp.rest;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.*;

public class HttpServletRequestWritableWrapper extends HttpServletRequestWrapper {

    private final ByteArrayInputStream decryptedDataBAIS;

    public HttpServletRequestWritableWrapper(HttpServletRequest request, byte[] decryptedData) {
        super(request);
        decryptedDataBAIS = new ByteArrayInputStream(decryptedData);
    }

    @Override
    public BufferedReader getReader() throws UnsupportedEncodingException {
    	return new BufferedReader(new InputStreamReader(decryptedDataBAIS));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
    	ServletInputStream inputStream=null;
    	inputStream= new ServletInputStream() {
            @Override
            public int read() {
            	int e=decryptedDataBAIS.read();
                return e;
            }

			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setReadListener(ReadListener arg0) {
				// TODO Auto-generated method stub
			}
        };
        return inputStream;
    }
}
