

class ParentController {
    
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ parentInstanceList: Parent.list( params ), parentInstanceTotal: Parent.count() ]
    }

    def show = {
        def parentInstance = Parent.get( params.id )

        if(!parentInstance) {
            flash.message = "Parent not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ parentInstance : parentInstance ]
        }
    }

    def delete = {
        def parentInstance = Parent.get( params.id )
        if(parentInstance) {
            try {
                parentInstance.delete(flush:true)
                flash.message = "Parent ${params.id} deleted"
                redirect(action:"list")
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Parent ${params.id} could not be deleted"
                redirect(action:"show",id:params.id)
            }
        }
        else {
            flash.message = "Parent not found with id ${params.id}"
            redirect(action:"list")
        }
    }

    def edit = {
        def parentInstance = Parent.get( params.id )

        if(!parentInstance) {
            flash.message = "Parent not found with id ${params.id}"
            redirect action:'list'
        }
        else {
            return [ parentInstance : parentInstance ]
        }
    }

    def update = {
        def parentInstance = Parent.get( params.id )
        if(parentInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(parentInstance.version > version) {
                    
                    parentInstance.errors.rejectValue("version", "parent.optimistic.locking.failure", "Another user has updated this Parent while you were editing.")

                    render view:'edit', model:[parentInstance:parentInstance]
                    return
                }
            }
            parentInstance.properties = params
            if(!parentInstance.hasErrors() && parentInstance.save()) {
                flash.message = "Parent ${params.id} updated"

                redirect action:'show', id:parentInstance.id
            }
            else {
                render view:'edit', model:[parentInstance:parentInstance]
            }
        }
        else {
            flash.message = "Parent not found with id ${params.id}"
            redirect action:'list'
        }
    }

    def create = {
        def parentInstance = new Parent()
        parentInstance.properties = params
        return ['parentInstance':parentInstance]
    }

    def save = {
        def parentInstance = new Parent(params)
        if(parentInstance.save(flush:true)) {
            flash.message = "Parent ${parentInstance.id} created"

            redirect action:"show", id:parentInstance.id
        }
        else {
            render view:'create', model:[parentInstance:parentInstance]
        }
    }
}
