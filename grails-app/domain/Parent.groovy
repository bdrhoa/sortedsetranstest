class Parent {

    static hasMany = [ children : Child ]

    String  name

    static constraints = {
        name(blank:false,unique:true)
    }
}
