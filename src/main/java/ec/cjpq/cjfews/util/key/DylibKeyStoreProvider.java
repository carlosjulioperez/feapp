package ec.cjpq.cjfews.util.key;

public class DylibKeyStoreProvider
  extends PKCS11KeyStoreProvider
{
  private static String CONFIG;
  
  public DylibKeyStoreProvider()
  {
    StringBuffer config = new StringBuffer();
    config.append("name=eToken\n");
    config.append("library=/usr/local/lib/libeTPkcs11.dylib\n");
    
    CONFIG = config.toString();
  }
  
  public String getConfig()
  {
    return CONFIG;
  }
}


/* Location:           C:\firmaDigital\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.DylibKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */