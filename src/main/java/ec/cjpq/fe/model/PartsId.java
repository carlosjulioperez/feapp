package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PartsId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PartsId  implements java.io.Serializable
 {


     private Integer id;
     private String partnumber;
     private String description;
     private String unit;
     private Double listprice;
     private Double sellprice;
     private Double lastcost;
     private Date priceupdate;
     private Double weight;
     private Double onhand;
     private String notes;
     private Boolean makemodel;
     private Boolean assembly;
     private Boolean alternate;
     private Double rop;
     private Integer inventoryAccnoId;
     private Integer incomeAccnoId;
     private Integer expenseAccnoId;
     private String bin;
     private Boolean obsolete;
     private Boolean bom;
     private String image;
     private String drawing;
     private String microfiche;
     private Integer partsgroupId;
     private Integer projectId;
     private Double avgcost;
     private String tariffHscode;
     private String countryorigin;
     private String barcode;
     private String toolnumber;
     private Character uselots;
     private String partnumber2;
     private BigDecimal fodinfa;
     private BigDecimal advaloren;

    public PartsId() {
    }

    public PartsId(Integer id, String partnumber, String description, String unit, Double listprice, Double sellprice, Double lastcost, Date priceupdate, Double weight, Double onhand, String notes, Boolean makemodel, Boolean assembly, Boolean alternate, Double rop, Integer inventoryAccnoId, Integer incomeAccnoId, Integer expenseAccnoId, String bin, Boolean obsolete, Boolean bom, String image, String drawing, String microfiche, Integer partsgroupId, Integer projectId, Double avgcost, String tariffHscode, String countryorigin, String barcode, String toolnumber, Character uselots, String partnumber2, BigDecimal fodinfa, BigDecimal advaloren) {
       this.id = id;
       this.partnumber = partnumber;
       this.description = description;
       this.unit = unit;
       this.listprice = listprice;
       this.sellprice = sellprice;
       this.lastcost = lastcost;
       this.priceupdate = priceupdate;
       this.weight = weight;
       this.onhand = onhand;
       this.notes = notes;
       this.makemodel = makemodel;
       this.assembly = assembly;
       this.alternate = alternate;
       this.rop = rop;
       this.inventoryAccnoId = inventoryAccnoId;
       this.incomeAccnoId = incomeAccnoId;
       this.expenseAccnoId = expenseAccnoId;
       this.bin = bin;
       this.obsolete = obsolete;
       this.bom = bom;
       this.image = image;
       this.drawing = drawing;
       this.microfiche = microfiche;
       this.partsgroupId = partsgroupId;
       this.projectId = projectId;
       this.avgcost = avgcost;
       this.tariffHscode = tariffHscode;
       this.countryorigin = countryorigin;
       this.barcode = barcode;
       this.toolnumber = toolnumber;
       this.uselots = uselots;
       this.partnumber2 = partnumber2;
       this.fodinfa = fodinfa;
       this.advaloren = advaloren;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="partnumber")
    public String getPartnumber() {
        return this.partnumber;
    }
    
    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="unit", length=5)
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Column(name="listprice", precision=17, scale=17)
    public Double getListprice() {
        return this.listprice;
    }
    
    public void setListprice(Double listprice) {
        this.listprice = listprice;
    }


    @Column(name="sellprice", precision=17, scale=17)
    public Double getSellprice() {
        return this.sellprice;
    }
    
    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }


    @Column(name="lastcost", precision=17, scale=17)
    public Double getLastcost() {
        return this.lastcost;
    }
    
    public void setLastcost(Double lastcost) {
        this.lastcost = lastcost;
    }


    @Column(name="priceupdate", length=13)
    public Date getPriceupdate() {
        return this.priceupdate;
    }
    
    public void setPriceupdate(Date priceupdate) {
        this.priceupdate = priceupdate;
    }


    @Column(name="weight", precision=17, scale=17)
    public Double getWeight() {
        return this.weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }


    @Column(name="onhand", precision=17, scale=17)
    public Double getOnhand() {
        return this.onhand;
    }
    
    public void setOnhand(Double onhand) {
        this.onhand = onhand;
    }


    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Column(name="makemodel")
    public Boolean getMakemodel() {
        return this.makemodel;
    }
    
    public void setMakemodel(Boolean makemodel) {
        this.makemodel = makemodel;
    }


    @Column(name="assembly")
    public Boolean getAssembly() {
        return this.assembly;
    }
    
    public void setAssembly(Boolean assembly) {
        this.assembly = assembly;
    }


    @Column(name="alternate")
    public Boolean getAlternate() {
        return this.alternate;
    }
    
    public void setAlternate(Boolean alternate) {
        this.alternate = alternate;
    }


    @Column(name="rop", precision=17, scale=17)
    public Double getRop() {
        return this.rop;
    }
    
    public void setRop(Double rop) {
        this.rop = rop;
    }


    @Column(name="inventory_accno_id")
    public Integer getInventoryAccnoId() {
        return this.inventoryAccnoId;
    }
    
    public void setInventoryAccnoId(Integer inventoryAccnoId) {
        this.inventoryAccnoId = inventoryAccnoId;
    }


    @Column(name="income_accno_id")
    public Integer getIncomeAccnoId() {
        return this.incomeAccnoId;
    }
    
    public void setIncomeAccnoId(Integer incomeAccnoId) {
        this.incomeAccnoId = incomeAccnoId;
    }


    @Column(name="expense_accno_id")
    public Integer getExpenseAccnoId() {
        return this.expenseAccnoId;
    }
    
    public void setExpenseAccnoId(Integer expenseAccnoId) {
        this.expenseAccnoId = expenseAccnoId;
    }


    @Column(name="bin")
    public String getBin() {
        return this.bin;
    }
    
    public void setBin(String bin) {
        this.bin = bin;
    }


    @Column(name="obsolete")
    public Boolean getObsolete() {
        return this.obsolete;
    }
    
    public void setObsolete(Boolean obsolete) {
        this.obsolete = obsolete;
    }


    @Column(name="bom")
    public Boolean getBom() {
        return this.bom;
    }
    
    public void setBom(Boolean bom) {
        this.bom = bom;
    }


    @Column(name="image")
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }


    @Column(name="drawing")
    public String getDrawing() {
        return this.drawing;
    }
    
    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }


    @Column(name="microfiche")
    public String getMicrofiche() {
        return this.microfiche;
    }
    
    public void setMicrofiche(String microfiche) {
        this.microfiche = microfiche;
    }


    @Column(name="partsgroup_id")
    public Integer getPartsgroupId() {
        return this.partsgroupId;
    }
    
    public void setPartsgroupId(Integer partsgroupId) {
        this.partsgroupId = partsgroupId;
    }


    @Column(name="project_id")
    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    @Column(name="avgcost", precision=17, scale=17)
    public Double getAvgcost() {
        return this.avgcost;
    }
    
    public void setAvgcost(Double avgcost) {
        this.avgcost = avgcost;
    }


    @Column(name="tariff_hscode")
    public String getTariffHscode() {
        return this.tariffHscode;
    }
    
    public void setTariffHscode(String tariffHscode) {
        this.tariffHscode = tariffHscode;
    }


    @Column(name="countryorigin")
    public String getCountryorigin() {
        return this.countryorigin;
    }
    
    public void setCountryorigin(String countryorigin) {
        this.countryorigin = countryorigin;
    }


    @Column(name="barcode")
    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    @Column(name="toolnumber")
    public String getToolnumber() {
        return this.toolnumber;
    }
    
    public void setToolnumber(String toolnumber) {
        this.toolnumber = toolnumber;
    }


    @Column(name="uselots", length=1)
    public Character getUselots() {
        return this.uselots;
    }
    
    public void setUselots(Character uselots) {
        this.uselots = uselots;
    }


    @Column(name="partnumber2")
    public String getPartnumber2() {
        return this.partnumber2;
    }
    
    public void setPartnumber2(String partnumber2) {
        this.partnumber2 = partnumber2;
    }


    @Column(name="fodinfa", precision=5)
    public BigDecimal getFodinfa() {
        return this.fodinfa;
    }
    
    public void setFodinfa(BigDecimal fodinfa) {
        this.fodinfa = fodinfa;
    }


    @Column(name="advaloren", precision=5)
    public BigDecimal getAdvaloren() {
        return this.advaloren;
    }
    
    public void setAdvaloren(BigDecimal advaloren) {
        this.advaloren = advaloren;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PartsId) ) return false;
		 PartsId castOther = ( PartsId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getPartnumber()==castOther.getPartnumber()) || ( this.getPartnumber()!=null && castOther.getPartnumber()!=null && this.getPartnumber().equals(castOther.getPartnumber()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getUnit()==castOther.getUnit()) || ( this.getUnit()!=null && castOther.getUnit()!=null && this.getUnit().equals(castOther.getUnit()) ) )
 && ( (this.getListprice()==castOther.getListprice()) || ( this.getListprice()!=null && castOther.getListprice()!=null && this.getListprice().equals(castOther.getListprice()) ) )
 && ( (this.getSellprice()==castOther.getSellprice()) || ( this.getSellprice()!=null && castOther.getSellprice()!=null && this.getSellprice().equals(castOther.getSellprice()) ) )
 && ( (this.getLastcost()==castOther.getLastcost()) || ( this.getLastcost()!=null && castOther.getLastcost()!=null && this.getLastcost().equals(castOther.getLastcost()) ) )
 && ( (this.getPriceupdate()==castOther.getPriceupdate()) || ( this.getPriceupdate()!=null && castOther.getPriceupdate()!=null && this.getPriceupdate().equals(castOther.getPriceupdate()) ) )
 && ( (this.getWeight()==castOther.getWeight()) || ( this.getWeight()!=null && castOther.getWeight()!=null && this.getWeight().equals(castOther.getWeight()) ) )
 && ( (this.getOnhand()==castOther.getOnhand()) || ( this.getOnhand()!=null && castOther.getOnhand()!=null && this.getOnhand().equals(castOther.getOnhand()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) )
 && ( (this.getMakemodel()==castOther.getMakemodel()) || ( this.getMakemodel()!=null && castOther.getMakemodel()!=null && this.getMakemodel().equals(castOther.getMakemodel()) ) )
 && ( (this.getAssembly()==castOther.getAssembly()) || ( this.getAssembly()!=null && castOther.getAssembly()!=null && this.getAssembly().equals(castOther.getAssembly()) ) )
 && ( (this.getAlternate()==castOther.getAlternate()) || ( this.getAlternate()!=null && castOther.getAlternate()!=null && this.getAlternate().equals(castOther.getAlternate()) ) )
 && ( (this.getRop()==castOther.getRop()) || ( this.getRop()!=null && castOther.getRop()!=null && this.getRop().equals(castOther.getRop()) ) )
 && ( (this.getInventoryAccnoId()==castOther.getInventoryAccnoId()) || ( this.getInventoryAccnoId()!=null && castOther.getInventoryAccnoId()!=null && this.getInventoryAccnoId().equals(castOther.getInventoryAccnoId()) ) )
 && ( (this.getIncomeAccnoId()==castOther.getIncomeAccnoId()) || ( this.getIncomeAccnoId()!=null && castOther.getIncomeAccnoId()!=null && this.getIncomeAccnoId().equals(castOther.getIncomeAccnoId()) ) )
 && ( (this.getExpenseAccnoId()==castOther.getExpenseAccnoId()) || ( this.getExpenseAccnoId()!=null && castOther.getExpenseAccnoId()!=null && this.getExpenseAccnoId().equals(castOther.getExpenseAccnoId()) ) )
 && ( (this.getBin()==castOther.getBin()) || ( this.getBin()!=null && castOther.getBin()!=null && this.getBin().equals(castOther.getBin()) ) )
 && ( (this.getObsolete()==castOther.getObsolete()) || ( this.getObsolete()!=null && castOther.getObsolete()!=null && this.getObsolete().equals(castOther.getObsolete()) ) )
 && ( (this.getBom()==castOther.getBom()) || ( this.getBom()!=null && castOther.getBom()!=null && this.getBom().equals(castOther.getBom()) ) )
 && ( (this.getImage()==castOther.getImage()) || ( this.getImage()!=null && castOther.getImage()!=null && this.getImage().equals(castOther.getImage()) ) )
 && ( (this.getDrawing()==castOther.getDrawing()) || ( this.getDrawing()!=null && castOther.getDrawing()!=null && this.getDrawing().equals(castOther.getDrawing()) ) )
 && ( (this.getMicrofiche()==castOther.getMicrofiche()) || ( this.getMicrofiche()!=null && castOther.getMicrofiche()!=null && this.getMicrofiche().equals(castOther.getMicrofiche()) ) )
 && ( (this.getPartsgroupId()==castOther.getPartsgroupId()) || ( this.getPartsgroupId()!=null && castOther.getPartsgroupId()!=null && this.getPartsgroupId().equals(castOther.getPartsgroupId()) ) )
 && ( (this.getProjectId()==castOther.getProjectId()) || ( this.getProjectId()!=null && castOther.getProjectId()!=null && this.getProjectId().equals(castOther.getProjectId()) ) )
 && ( (this.getAvgcost()==castOther.getAvgcost()) || ( this.getAvgcost()!=null && castOther.getAvgcost()!=null && this.getAvgcost().equals(castOther.getAvgcost()) ) )
 && ( (this.getTariffHscode()==castOther.getTariffHscode()) || ( this.getTariffHscode()!=null && castOther.getTariffHscode()!=null && this.getTariffHscode().equals(castOther.getTariffHscode()) ) )
 && ( (this.getCountryorigin()==castOther.getCountryorigin()) || ( this.getCountryorigin()!=null && castOther.getCountryorigin()!=null && this.getCountryorigin().equals(castOther.getCountryorigin()) ) )
 && ( (this.getBarcode()==castOther.getBarcode()) || ( this.getBarcode()!=null && castOther.getBarcode()!=null && this.getBarcode().equals(castOther.getBarcode()) ) )
 && ( (this.getToolnumber()==castOther.getToolnumber()) || ( this.getToolnumber()!=null && castOther.getToolnumber()!=null && this.getToolnumber().equals(castOther.getToolnumber()) ) )
 && ( (this.getUselots()==castOther.getUselots()) || ( this.getUselots()!=null && castOther.getUselots()!=null && this.getUselots().equals(castOther.getUselots()) ) )
 && ( (this.getPartnumber2()==castOther.getPartnumber2()) || ( this.getPartnumber2()!=null && castOther.getPartnumber2()!=null && this.getPartnumber2().equals(castOther.getPartnumber2()) ) )
 && ( (this.getFodinfa()==castOther.getFodinfa()) || ( this.getFodinfa()!=null && castOther.getFodinfa()!=null && this.getFodinfa().equals(castOther.getFodinfa()) ) )
 && ( (this.getAdvaloren()==castOther.getAdvaloren()) || ( this.getAdvaloren()!=null && castOther.getAdvaloren()!=null && this.getAdvaloren().equals(castOther.getAdvaloren()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getPartnumber() == null ? 0 : this.getPartnumber().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getUnit() == null ? 0 : this.getUnit().hashCode() );
         result = 37 * result + ( getListprice() == null ? 0 : this.getListprice().hashCode() );
         result = 37 * result + ( getSellprice() == null ? 0 : this.getSellprice().hashCode() );
         result = 37 * result + ( getLastcost() == null ? 0 : this.getLastcost().hashCode() );
         result = 37 * result + ( getPriceupdate() == null ? 0 : this.getPriceupdate().hashCode() );
         result = 37 * result + ( getWeight() == null ? 0 : this.getWeight().hashCode() );
         result = 37 * result + ( getOnhand() == null ? 0 : this.getOnhand().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         result = 37 * result + ( getMakemodel() == null ? 0 : this.getMakemodel().hashCode() );
         result = 37 * result + ( getAssembly() == null ? 0 : this.getAssembly().hashCode() );
         result = 37 * result + ( getAlternate() == null ? 0 : this.getAlternate().hashCode() );
         result = 37 * result + ( getRop() == null ? 0 : this.getRop().hashCode() );
         result = 37 * result + ( getInventoryAccnoId() == null ? 0 : this.getInventoryAccnoId().hashCode() );
         result = 37 * result + ( getIncomeAccnoId() == null ? 0 : this.getIncomeAccnoId().hashCode() );
         result = 37 * result + ( getExpenseAccnoId() == null ? 0 : this.getExpenseAccnoId().hashCode() );
         result = 37 * result + ( getBin() == null ? 0 : this.getBin().hashCode() );
         result = 37 * result + ( getObsolete() == null ? 0 : this.getObsolete().hashCode() );
         result = 37 * result + ( getBom() == null ? 0 : this.getBom().hashCode() );
         result = 37 * result + ( getImage() == null ? 0 : this.getImage().hashCode() );
         result = 37 * result + ( getDrawing() == null ? 0 : this.getDrawing().hashCode() );
         result = 37 * result + ( getMicrofiche() == null ? 0 : this.getMicrofiche().hashCode() );
         result = 37 * result + ( getPartsgroupId() == null ? 0 : this.getPartsgroupId().hashCode() );
         result = 37 * result + ( getProjectId() == null ? 0 : this.getProjectId().hashCode() );
         result = 37 * result + ( getAvgcost() == null ? 0 : this.getAvgcost().hashCode() );
         result = 37 * result + ( getTariffHscode() == null ? 0 : this.getTariffHscode().hashCode() );
         result = 37 * result + ( getCountryorigin() == null ? 0 : this.getCountryorigin().hashCode() );
         result = 37 * result + ( getBarcode() == null ? 0 : this.getBarcode().hashCode() );
         result = 37 * result + ( getToolnumber() == null ? 0 : this.getToolnumber().hashCode() );
         result = 37 * result + ( getUselots() == null ? 0 : this.getUselots().hashCode() );
         result = 37 * result + ( getPartnumber2() == null ? 0 : this.getPartnumber2().hashCode() );
         result = 37 * result + ( getFodinfa() == null ? 0 : this.getFodinfa().hashCode() );
         result = 37 * result + ( getAdvaloren() == null ? 0 : this.getAdvaloren().hashCode() );
         return result;
   }   


}


