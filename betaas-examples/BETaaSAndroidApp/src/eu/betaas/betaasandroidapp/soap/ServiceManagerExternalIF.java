/**

Copyright 2014 ATOS SPAIN S.A.

Licensed under the Apache License, Version 2.0 (the License);
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Authors :
Sergio García Villalonga. Atos Research and Innovation, Atos SPAIN SA
@email sergio.garciavillalonga@atos.net
**/

package eu.betaas.betaasandroidapp.soap;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.5
//
// Date Of Creation: 5/9/2014 8:56:34 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import eu.betaas.betaasandroidapp.soap.WS_Enums.SoapProtocolVersion;
import android.os.AsyncTask;

public class ServiceManagerExternalIF {
    
    public String NAMESPACE ="http://api.servicemanager.service.betaas.eu/";
    public String url="";
    public int timeOut = 10000;
    public IWsdl2CodeEvents eventHandler;
    public SoapProtocolVersion soapVersion;
    
    public ServiceManagerExternalIF(){}
    
    public ServiceManagerExternalIF(IWsdl2CodeEvents eventHandler)
    {
        this.eventHandler = eventHandler;
    }
    public ServiceManagerExternalIF(IWsdl2CodeEvents eventHandler,String url)
    {
        this.eventHandler = eventHandler;
        this.url = url;
    }
    public ServiceManagerExternalIF(IWsdl2CodeEvents eventHandler,String url,int timeOutInSeconds)
    {
        this.eventHandler = eventHandler;
        this.url = url;
        this.setTimeOut(timeOutInSeconds);
    }
    public void setTimeOut(int seconds){
        this.timeOut = seconds * 1000;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void getLastAppIDAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getLastAppIDAsync(null);
    }
    
    public void getLastAppIDAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getLastAppID(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getLastAppID", result);
                }
            }
        }.execute();
    }
    
    public String getLastAppID(){
        return getLastAppID(null);
    }
    
    public String getLastAppID(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","getLastAppID");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getLastAppID", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getLastAppID", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void unregisterAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        unregisterAsync(arg0, arg1, null);
    }
    
    public void unregisterAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return unregister(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("unregister", result);
                }
            }
        }.execute();
    }
    
    public boolean unregister(String arg0,String arg1){
        return unregister(arg0, arg1, null);
    }
    
    public boolean unregister(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","unregister");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/unregister", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/unregister", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void uninstallApplicationAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        uninstallApplicationAsync(arg0, arg1, null);
    }
    
    public void uninstallApplicationAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return uninstallApplication(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("uninstallApplication", result);
                }
            }
        }.execute();
    }
    
    public boolean uninstallApplication(String arg0,String arg1){
        return uninstallApplication(arg0, arg1, null);
    }
    
    public boolean uninstallApplication(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","uninstallApplication");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/uninstallApplication", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/uninstallApplication", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void registerAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        registerAsync(arg0, arg1, null);
    }
    
    public void registerAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return register(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("register", result);
                }
            }
        }.execute();
    }
    
    public boolean register(String arg0,String arg1){
        return register(arg0, arg1, null);
    }
    
    public boolean register(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","register");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/register", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/register", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void getTaskDataAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getTaskDataAsync(arg0, arg1, null);
    }
    
    public void getTaskDataAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getTaskData(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getTaskData", result);
                }
            }
        }.execute();
    }
    
    public String getTaskData(String arg0,String arg1){
        return getTaskData(arg0, arg1, null);
    }
    
    public String getTaskData(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","getTaskData");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getTaskData", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getTaskData", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void getLastAppServiceIDAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getLastAppServiceIDAsync(null);
    }
    
    public void getLastAppServiceIDAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getLastAppServiceID(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getLastAppServiceID", result);
                }
            }
        }.execute();
    }
    
    public String getLastAppServiceID(){
        return getLastAppServiceID(null);
    }
    
    public String getLastAppServiceID(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","getLastAppServiceID");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getLastAppServiceID", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getLastAppServiceID", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void installApplicationAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        installApplicationAsync(arg0, null);
    }
    
    public void installApplicationAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return installApplication(arg0, headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("installApplication", result);
                }
            }
        }.execute();
    }
    
    public String installApplication(String arg0){
        return installApplication(arg0, null);
    }
    
    public String installApplication(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","installApplication");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/installApplication", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/installApplication", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void testAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        testAsync(arg0, null);
    }
    
    public void testAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return test(arg0, headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("test", result);
                }
            }
        }.execute();
    }
    
    public String test(String arg0){
        return test(arg0, null);
    }
    
    public String test(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","test");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/test", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/test", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void getThingServiceDataAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getThingServiceDataAsync(arg0, arg1, null);
    }
    
    public void getThingServiceDataAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getThingServiceData(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getThingServiceData", result);
                }
            }
        }.execute();
    }
    
    public String getThingServiceData(String arg0,String arg1){
        return getThingServiceData(arg0, arg1, null);
    }
    
    public String getThingServiceData(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://api.servicemanager.service.betaas.eu/","getThingServiceData");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getThingServiceData", soapEnvelope,headers);
            }else{
                httpTransport.call("http://api.servicemanager.service.betaas.eu/getThingServiceData", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
}
