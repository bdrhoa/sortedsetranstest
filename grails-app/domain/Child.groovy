class Child {

    static belongsTo = Parent

    String name

    String pet

    Parent parent

    static constraints = {
        name(blank:false,unique:true)
        pet(blank:false)
    }
}
