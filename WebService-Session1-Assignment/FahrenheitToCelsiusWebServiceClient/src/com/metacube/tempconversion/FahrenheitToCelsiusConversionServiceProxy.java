package com.metacube.tempconversion;

public class FahrenheitToCelsiusConversionServiceProxy implements com.metacube.tempconversion.FahrenheitToCelsiusConversionService {
  private String _endpoint = null;
  private com.metacube.tempconversion.FahrenheitToCelsiusConversionService fahrenheitToCelsiusConversionService = null;
  
  public FahrenheitToCelsiusConversionServiceProxy() {
    _initFahrenheitToCelsiusConversionServiceProxy();
  }
  
  public FahrenheitToCelsiusConversionServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFahrenheitToCelsiusConversionServiceProxy();
  }
  
  private void _initFahrenheitToCelsiusConversionServiceProxy() {
    try {
      fahrenheitToCelsiusConversionService = (new com.metacube.tempconversion.FahrenheitToCelsiusConversionServiceServiceLocator()).getFahrenheitToCelsiusConversionService();
      if (fahrenheitToCelsiusConversionService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fahrenheitToCelsiusConversionService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fahrenheitToCelsiusConversionService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fahrenheitToCelsiusConversionService != null)
      ((javax.xml.rpc.Stub)fahrenheitToCelsiusConversionService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.tempconversion.FahrenheitToCelsiusConversionService getFahrenheitToCelsiusConversionService() {
    if (fahrenheitToCelsiusConversionService == null)
      _initFahrenheitToCelsiusConversionServiceProxy();
    return fahrenheitToCelsiusConversionService;
  }
  
  public double getValueInCelsius(double fahrenheitValue) throws java.rmi.RemoteException{
    if (fahrenheitToCelsiusConversionService == null)
      _initFahrenheitToCelsiusConversionServiceProxy();
    return fahrenheitToCelsiusConversionService.getValueInCelsius(fahrenheitValue);
  }
  
  
}