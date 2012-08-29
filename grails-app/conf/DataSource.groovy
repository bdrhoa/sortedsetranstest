import org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration
dataSource {
	configClass = GrailsAnnotationConfiguration.class
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
        dialect = org.hibernate.dialect.MySQLInnoDBDialect
	//driverClassName = "com.p6spy.engine.spy.P6SpyDriver"
	zeroDateTimeBehavior="convertToNull" //Java can't convert ''0000-00-00 00:00:00' to TIMESTAMP
  	username = "root"
  	password = "4980714"
	loggingSql=false
}

hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
				url = "jdbc:mysql://localhost:3306/transtest?zeroDateTimeBehavior=convertToNull"

		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/transtest?zeroDateTimeBehavior=convertToNull"

		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/transtest?zeroDateTimeBehavior=convertToNull"
		}
	}
}