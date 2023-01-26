spockReports {
    // set all properties at once
    set([
            // output directory relative to working directory
            'com.athaydes.spockframework.report.outputDir'                                         : 'build/geb-spock-reports',

            // let's use the TemplateReportCreator to utilize our custom template
            'com.athaydes.spockframework.report.IReportCreator'                                    : 'com.athaydes.spockframework.report.template.TemplateReportCreator',

            // if true, code blocks are shown
            'com.athaydes.spockframework.report.showCodeBlocks'                                    : 'true',

            // specific properties to the TemplateReportCreator
            'com.athaydes.spockframework.report.template.TemplateReportCreator.specTemplateFile'   : '/templates/spec-template.html',
            'com.athaydes.spockframework.report.template.TemplateReportCreator.reportFileExtension': 'html',
            'com.athaydes.spockframework.report.template.TemplateReportCreator.summaryTemplateFile': '/templates/summary-template.html',
            'com.athaydes.spockframework.report.template.TemplateReportCreator.summaryFileName'    : 'index.html',

            // Set the name of the project under test so it can be displayed in the report or leave empty and it will be ignored
            'com.athaydes.spockframework.report.projectName'                                       : 'Project Name',

            // Set the version of the project under test so it can be displayed in the report or leave empty and it will be ignored
            'com.athaydes.spockframework.report.projectVersion'                                    : '',
    ])
}