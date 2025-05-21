package action;

public class ValidationPropertyUtil 
{
	//Create Report:---
		public String ExpectedDBName="Pantara AS2008";
		public String DBErrorMsg="Expected DB name is not the same.";

		public String StandardReportMsg="Creates a new standard report with tables and charts.";
		public String ReportNameErrMsg="Report Name is not same a expected.";
		public String ExptSelectReportMsgXpath="standard report";
		
		//New Layout filter:-
		public String ExptfilterBarSuccessText="Inserts a filter bar into the report.";
		public String ErrFilterBarMsg="Message is not same as expected.";
		public String FilterLayoutComName="DimensionFilter";

		//Opening new Layout Componets window
		public String ExpectedComponentHeader="Components";
		public String ErrComponentMsg="Layout Components window is not opened.";

		//Caption Text verification
		public String CaptionTxt="CaptionBug";
		public String CategoryNameTxtField="Category.Category";
		public String FilterCaptionNameErrMsg="Caption property is the same as expected.";
		//Check header of Filter Bar Property popup
		public String ErrFilterPropHeaderMsg="Header of the property popup is not the same as expected.";

		//Bug 17164
		public int priorityValue=2;
		public String CellInput="50";
		//Bug 17238
		public String CalculatedElemntTxt="Calculated elements";
		//Bug 17239
		public int ListCbNum=5;
		public String MashupRow="Row";
		//Release version check:-
		public String Releaseversion="8.9";
		//Bug 15894
		public String OLAPfunctntxtdata="\"Sales\"";
		public String mixdataFormula="GetElement"+"("+OLAPfunctntxtdata+")";
		//Bug 11112
		public String AllReportTxtheader="Repository";
		//Bug 18896
		public String TitleInputName="Report Title";
		public String TitlePropText="Properties...";
		public String TitlePropertyErrMsg="Title does not have 'Properties' in context menu option.";
		public String TitleTextReName="Report ReNameTitle";
		//Bug 18840
		public String AdHocExportHederTxt="AdHoc Export";
		public String ErrAdhocExportHederMsg="Header message is not correct as expected.";
		//(do change after excel sheet)-18840
		public String AdhocFileNameValidateTxt="Bug Report_18840"+"."+"pdf";
		public String[] ElementSelectAutoHide={"Used Car","Company Car"};
		//Dataview Properties --> Performance --> Build header mode 
		public String Buildoptn1="Based on element selection";
		public String Buildoptn2="From result (autoexists)";
		//Bug 18608
		public String WithoutInputLoginMsg="No connection could be made because the target machine actively refused it.";
		public String UsernameErrMsg="Please enter username and password";
		public String WrongErrMsg="UserName/password error message is not correct as expected.";
		public String ServerErrMsg="The user 'Admin' is not assigned to this product.";
		public String PasswordErrMsg="The user was not found or the password is invalid.";
		public String WrongValueErrMsg="The user was not found or the password is invalid.";
		public String NoConnectionLocalhostErrmsg="No connection could be made because the target machine actively refused it.";
		//Bug 11930
		public String ExptLocalExportHederTxt="New Local Export";
		public String LocalExportname="NewLocalExportReport";
		public String NewExportCallNme="ExportNewCallAction";
		public String NewLayoutActionName="NewExportLayout";

		//Bug 16372
		public String ContainerElementTxt="Container elements";
		public String ExptElementGrpHeaderTxt="Element Groups";		
		public String[] ExptElementList={"Criteria DDL","Data DDL","Script DDL","Standard SDL"};

		public String CriteriaDDLName="NewCriteriaDDL";

		public String ElementGrpSelected="Container";

		//Mashup Calculated Element:-
		public String ExptErrMashupMsgText="#ERR: formula error: "+"\""+"Index range error in element reference"+"\"";

		//RDB Data view:===============
		public String ExptSQLDataViewMessage="Creates a new SQL DataView.";
		public String DataViewSQLQuery="SELECT  * FROM  dbo.Cities where Salesorg='Motorcars of UK'";
		//MDX Data view:===============
		public String ExptMDXDataViewMessage="Creates a new MDX DataView.";
		public String DataViewMDXQuery="SELECT NON EMPTY{ [Measures].[Cost] } ON COLUMNS,NON EMPTY { ([Time].[Time].[Quarters].ALLMEMBERS ) } ON Rows FROM [Sales]";

		//AnaliticalVIZ:===================
		public String AnaliticalVizIncelBarMsg="Creates a new In Cell Bar analysis.";
		public String AnaliticalVizMiniChartMsg="Creates a new minichart.";
		public String AnaliticalVizGradientMsg="Creates a new gradient analysis.";
		public String AnaliticalVizThresHoldMsg="Creates a new threshold analysis.";
		
		//Export Report:============================
		public String ExportSuccessMsg="Export finished successfully";

		//===========================================
		//Table properties:-
		public String[] HorizontalAlignmntList={"Left","Center","Right","Stretch"};
		public String[] VerticalAlignmntList={"Top","Center","Bottom"};
		public String ExptShadowOffsetErrMsg="Please enter a value between 1 and 10!";
		
		//Table Context Menu:-=====================================
		public String[] TablepropertyList={"Position","Headers","Rows","Columns","Data Area","Cell Size","Border","Background","Margins","Layout","General Settings"};
		public String[] TableRowpropertyList={"Headers","Rows"};
		public String[] TableColumnPropertyList={"Headers","Columns"};
		
		public String[] DataViewPropList={"General Settings","Settings","Formatting","Performance","Value entry behavior"};
		public String[] RangePropHedersList={"Range Settings","Hierarchy Navigation"};
		
		public String[] ElementPropTabsList={"Element","Value Format","Data Cell","Header Cell","Chart","Maps"};
		
		//Calculated TestCase Validation:-

		public String[] CalculatedElementList={"-SEPARATOR-","FORMULA","MASHUP","SUM","DIFFERENCE","PRODUCT","PRODUCT (X*Y)","AVERAGE","MINIMUM","MAXIMUM","DEVIATION (X-Y)","DEVIATION % (X-Y)/Y","DEVIATION % (X-Y)/|Y|","DEVIATION (Y-X)","DEVIATION % (Y-X)/X","DEVIATION % (Y-X)/|X|","QUOTIENT (X/Y)","QUOTIENT (Y/X)","PERCENTAGE","PERCENTAGE STACKED","RANK ASCENDING","RANK DESCENDING","ELEMENTCOUNT","MEDIAN","VARIANCE","STANDARD DEVIATION"};
				
		//UAT Testcase:=========================
		
		public String UATLocalExportname="NewLocalExport12742";
		public String UATMashupLocalExportname="NewLocalExport16758";
		
		public String LayoutMapName="NewLayoutMap";
		
		public String ExptGaugeSuccessText="Inserts a gauge into the report.";
		public String GaugeLayoutName="NewLayoutGauge";
		public String selectedGauge="Round gauge";
		
		public String ExptBubbleChatSuccessMsg="Inserts a bubble chart into the report.";
		public String BubbleLayoutName="NewLayoutBubble";
		
		public  String[] BubblechatPropList={"Chart Type","Chart Area (3D Settings)","Datapoint Labels","Datapoint Markers"};
		
		public String ExptVerticalWFChatSuccessMsg="Inserts a vertical waterfall chart into the report.";
		public String VerWFSeries="Rows";
		public String VerWFLayoutName="NewLayoutVerwf";
		
		public String ExptABCChatSuccessMsg="Inserts an ABC classification chart into the report.";
		public String AbcArea="Smoothed areas";
		public String VerAbcLayoutName="NewLayoutVerwf";
		
		public String ExptABCTableSuccessMsg="Inserts an ABC classification table into the report.";
		public String VerAbcTableName="NewLayoutAbcTable";
		
		public String ExptSelectionlayoutSuccessMsg="Inserts a selection bar into the report.";
		public String VerSelLayoutName="NewSelectionLayout";
		public String DisplayStyle="Red pin";
		public String FontStyl="Verdana";
		
		public String FilterArrangementTyp="Stacked";
		
		public String ExptChatLayoutSuccessMsg="Inserts a chart into the report.";
		public String VerchatLayoutName="NewchatLayout";
		public String VerChatSeriesTyp="Stepped line";
		
		public String ExptTableSuccessMsg="Inserts a table into the report.";
		public String VerTableLayoutName="NewTableLayout";
		
		public String ExptImgSuccessMsg="Inserts an image into the report.";
		public String VerImgLayoutName="NewImgLayout";
		//public String Imgname="TestImg";
		public String sizingTyp="Explicit";
		
		public String ExptTitleSuccessMsg="Inserts a title into the report.";
		public String VerTitleLayoutName="NewTitleLayout";
		public String TitleTexttyp="Text shadow";
		public String Titlename="TestTitle";
		
		public String ExptActionSuccessMsg="Inserts an action bar into the report.";
		public String VerActionLayoutName="NewActionLayout";
		public String ActWidthmode="Explicit width";
		public String ActionvalMsg="Creates a new animated action to iterate a filter automatically.";
		
		public String ReportChatTyp="Stepped Line";
		
		public String ReportSelectionBar="Function";
		
		public String ABCreportMsg="Creates a new report for ABC classification.";
		
		public String ABCeportSelectionBar="Customer by Region/ZIP";
		
		public String NeutralLanguageDesp="Report_Neutral_Language";
		public String EnLanguageDesp="Report_English_Language";
		public String GELanguageDesp="Report_German_Language";
		
		public String ReportNameEn="Report_EnLanguageTerm";
		public String ReportNameGE="Report_GeLanguageTerm";
		
		public String ContScriptDDL="ContainrSDDL";
		public String RowClientRuleName="RClientRule";
		public String RowClientRule="SumOfSDL("+"\""+"A - Training Sales.[Products].[Product]"+"\","+"\""+"Exotic"+"\""+")";
		
		public String ColumnClientRuleName="ColClientRule";
		public String ColumnClientRule="SumOfElems("+"\""+"A - Training Sales.[Time].[Time]"+"\","+"\""+"Q1 2014\","+"\"Q2 2014\""+")+10";
		
		public String ContDataDDL="ContainerDataDDL";
		
		public String[] SelectSubElementList={"Remove Element","Keep Element","Selection dialog..."};
		public String[] HideElementsSubEleList={"Hide Columns by Index","Hide Columns by Element Path","Hide / Show Columns..."};
		public String[] HideShowpageTextList={"Hide by element","Hide by index"};
		public String[] RowHideElementsSubEleList={"Hide Rows by Index","Hide Rows by Element Path","Hide / Show Rows..."};
		public String[] DoubleClickSubEleList={"Expand/Collapse","Execute first action","DrillDown"};
		public String[] RepositorySubEleList={"Connect to C8 Server...","New Message...","Messages...","Image Manager...","Print Templates Manager...","Export Template Manager...","Global Permissions...","Change Password...","User Settings...","Repository Settings..."};
		public String[] ChangePswdTextList={"User:","Old password:","New password:","Verification:"};

		public String[] LogOnWindowTextList={"Authentication:","User Name:","Password:","Server:"};
		public String[] MessageWinTextList={"From:","Subject:"};
		
		public String[] PrintNewTemplateTextList={"Page","Header","Footer","Properties"};
		
		public String[] GlobalPermissionbtnTextList={"Take Ownership","Set Ownership...","Effective Permissions...","Add Permission...","Add Role...","Remove"};
		
		public String[] UserSettingSublist={"General","Startup","Database Connections","Mail"};

		public String[] NewReportsTextList={"Standard Report","ABC Classification","Empty Report","Relational Report","MDX Report","Entry Report","Report from a Template","Local Export"};
		
		public String NavigatorLocalExport="NavToolLocalExport";
		
		//ReloginErrmsg:====================
		
		public String ReLoginWithoutUN="No connection could be made because the target machine actively refused it.";
		
		public String[] FormulaComponentList={"String Functions","Math Functions","Date/Time Functions","Aggregation Functions","Miscellaneous Functions","Variables"};
		

	//Karishma:=============================
		public String ExpTraining="Training";
		public String ExpDicecubedatview="Dice Cube DataViews";
		public String ErrorMessage="Selected List Is Not Availabele";
		public String expComponent="Components";
}
