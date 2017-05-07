jQuery.child = {
		userDataTable:null,
		initSearchDataTable : function() {
			alert("22555");
			if (jquery_datable == null) {
				this.userDataTable = $('#dt_table_view').on
				('preXhr.dt', function ( e, settings, data ) {
			        data.sessionId = '555555ggg5555';
			     } ).dataTable({
		            "ajax": {
		                "url": "http://127.0.0.1:8080/ymgl/admin/child/list",
		                "type": "POST"
		              },
					"columns" : [{
						"data" : "id"
					}, {
						"data" : "name"
					},{
						"data" : "","defaultContent": "<button>Edit</button>",
					},{
						"data" : "","defaultContent": "<button>Edit</button>",
					},{
						"data" : "","defaultContent": "<button>Edit</button>",
					},{
						"data" : "","defaultContent": "<button>Edit</button>",
					},{
						"data" : "","defaultContent": "<button>Edit</button>"
					}]
				});
			}else{
				alert("ddgggdeeeeeeeeeeeeeff");
				alert(jQuery.child.userDataTable.api());
				jQuery.child.userDataTable.draw();
			}
		}
		
};