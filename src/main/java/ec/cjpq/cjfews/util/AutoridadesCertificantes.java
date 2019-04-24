package ec.cjpq.cjfews.util;

public enum AutoridadesCertificantes
{
  ANF("ANF EC 1", "ANF Autoridad Intermedia", "ANF AC", "EC", "1.3.6.1.4.1.37442"),  BANCO_CENTRAL("AC BANCO CENTRAL DEL ECUADOR", "ENTIDAD DE CERTIFICACION DE INFORMACION-ECIBCE", "BANCO CENTRAL DEL ECUADOR", "EC", "1.3.6.1.4.1.37947"),  SECURITY_DATA("AUTORIDAD DE CERTIFICACION SUB SECURITY DATA", "ENTIDAD DE CERTIFICACION DE INFORMACION", "SECURITY DATA S.A.", "EC", "1.3.6.1.4.1.37746");
  
  private final String cn;
  private final String ou;
  private final String o;
  private final String c;
  private final String oid;
  
  private AutoridadesCertificantes(String cn, String ou, String o, String c, String oid)
  {
    this.c = c;
    this.o = o;
    this.cn = cn;
    this.ou = ou;
    this.oid = oid;
  }
  
  public String getC()
  {
    return this.c;
  }
  
  public String getCn()
  {
    return this.cn;
  }
  
  public String getO()
  {
    return this.o;
  }
  
  public String getOu()
  {
    return this.ou;
  }
  
  public String getOid()
  {
    return this.oid;
  }
}


/* Location:           C:\firmaDigital\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.AutoridadesCertificantes
 * JD-Core Version:    0.7.0.1
 */