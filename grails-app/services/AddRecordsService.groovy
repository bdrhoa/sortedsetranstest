class AddRecordsService {

    static transactional = true



    def addAll(params) {
        println "add all"
        println params
        def Parent theParent =  addParent(params.parentName)
        def Child theChild   = addChild(params.childName,params.petName,theParent)

        println theParent
        println theChild
        
    }

    def addParent(pName) {
        println "add parent: ${pName}"
        def theParent = new Parent(name:pName)
        theParent.save(failOnError:true)
        /*
        if(!theParent.save()){
            throw new RuntimeException('unable to save parent')
        } */

        return theParent
    }

    def addChild(cName,pName,Parent theParent) {
        println "add child: ${cName}"
        def theChild = new Child(name:cName,pet:pName,parent:theParent)
 
       theChild.save(failOnError:true)


/*
        if(!theChild.save()){
            println theChild.errors
            println "arguments: ${theChild.error.getModel()}"
             
             //throw new RuntimeException(theChild.errors) //org.springframework.validation.BeanPropertyBindingResult
            throw new RuntimeException('unable to save child')
        } 
        
*/
        return theChild
    }

}
