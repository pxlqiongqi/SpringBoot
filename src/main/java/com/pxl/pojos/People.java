package com.pxl.pojos;

public class People extends BasePojo{
    private Integer id;

    private String name;

    private String idno;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }
    public People(){
    	
    }
	public People(String name, String idno) {
		super();
		this.name = name;
		this.idno = idno;
	}
}