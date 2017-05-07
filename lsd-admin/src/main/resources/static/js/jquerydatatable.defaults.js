$.extend( true, $.fn.dataTable.defaults, {
	 "searching": false,
	 "ordering": true,
	"autoWidth" : false,
	"displayLength" : 10,
	"lengthMenu" : [ 5, 10, 25, 550],
	"serverSide" : true,
	"serverMethod" : "POST",
	"processing" : true,
	"sort" : true,
	"dom": 'lrtip',
	'language': {  
        'emptyTable': '没有数据',  
        'loadingRecords': '加载中...',  
        'processing': '查询中...',  
        'search': '检索:',  
        'lengthMenu': '每页 _MENU_ 条',  
        'zeroRecords': '没有数据',  
        'paginate': {  
            'first':      '第一页',  
            'last':       '最后一页',  
            'next':       '',  
            'previous':   ''  
        },  
        'info': '第 _PAGE_ 页 / 总 _PAGES_ 页',  
        'infoEmpty': '没有数据',  
        'infoFiltered': '(过滤总件数 _MAX_ 条)'  
    },
    "sort" : false,
} );
