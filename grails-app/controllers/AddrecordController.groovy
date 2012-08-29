class AddrecordController {
    
    def addRecordsService

    def index = {
        redirect action:"show", params:params
    }
    
    def add = {
        println "do add"

        
        try {
            addRecordsService.addAll(params)
        } catch (java.lang.RuntimeException re){

            println "errors: ${re.errors}"
            println "params: ${params}"
            
            def errorMessages = re.errors.allErrors.collect { g.message(error:it) }
            println  errorMessages
            flash.message = g.message(code:"addRecord.save.failed")
            flash.errors = errorMessages
            flash.params = params
            render view:"show",  params:params
            return
          
        }
        redirect action:"show"

    }

    def show = {println "params2: ${params}"}

}
