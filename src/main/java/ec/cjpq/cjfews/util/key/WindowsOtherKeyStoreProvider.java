package ec.cjpq.cjfews.util.key;

public class WindowsOtherKeyStoreProvider
  extends PKCS11KeyStoreProvider
{
  private static final String config;
  
  static
  {
    StringBuffer sb = new StringBuffer();
    sb.append("name=Safenetikey2032\n");
    sb.append("library=C:\\WINDOWS\\SYSTEM32\\dkck201.dll\n");
    sb.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
    config = sb.toString();
  }
  
  public String getConfig()
  {
    return config;
  }
}


/* Location:           C:\firmaDigital\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.WindowsOtherKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */