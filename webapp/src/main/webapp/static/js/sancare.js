$(document)
		.ready(
				function() {

					var rselected = [];
					// setup global ajax requests
					$.ajaxSetup({
						beforeSend : function(xhr, settings) {
							xhr.setRequestHeader("X-AjaxRequest", "1");
						},
						complete : function(xhr, textStatus) {
							if (xhr.status == 601) {
								// alert("xhr status: " + xhr.status);
								window.location.reload();
							}
						}
					});

					/*
					 * setting the datepicker settings
					 */
					$(".uiDateTextbox").datepicker({
						changeMonth : true,
						changeYear : true,
						dateFormat : 'yy-mm-dd'
					});

					$(".uiDateTextbox").live("focus", function() {
						$(this).datepicker({
							changeMonth : true,
							changeYear : true,
							dateFormat : 'yy-mm-dd'
						});
					});

					/*
					 * setup the ajax loader
					 */
					$("#loader").hide().ajaxStart(function() {
						$(this).show();
					}).ajaxStop(function() {
						$(this).hide();
					});

					/**
					 * initializing global dialog box
					 */
					$('#dialogBox')
							.dialog(
									{
										autoOpen : false,
										modal : true,
										beforeClose : function(event, ui) {
											if (window
													.confirm("Do you want to close this window?")) {
												return true
											} else
												return false;

											return true;
										}
									});

					/**
					 * initializing global button theme
					 */
					$(".uiButton").button();

					$("table.recordTable tbody tr")
							.live(
									'click',
									function(event) {
										if (event.target.type == 'checkbox') {
											if ($(':checkbox', this).attr(
													'checked')) {
												$(
														"table.recordTable tr.selected")
														.removeClass("selected");
												$(this).addClass("selected");

											} else
												$(this).removeClass("selected");
										} else {

											var url = $(this).attr("url");
											if (url != null) {
												window.open(url);
											}

											if ($(':checkbox', this).attr(
													'checked')
													|| $(this).hasClass(
															'selected')) {
												$(this).removeClass("selected");
												$(':checkbox', this).attr(
														'checked', false);
												// alert($(':checkbox',
												// this).is('checked'));
												rselected.pop();
											} else {
												// alert();
												$(
														"table.recordTable tr.selected")
														.removeClass("selected");
												$(
														"table.recordTable tr input:checked")
														.attr("checked", false);

												$(this).addClass("selected");
												$(':checkbox', this).attr(
														'checked', true);
												// alert($(':checkbox',
												// this).is('checked'));
												// var myArray =
												// $("['checked'=true]");
												// alert(myArray.size());
											}
										}

										$("tr[id$='-hidden']").addClass("hide");

										if ($(':checkbox', this)
												.attr('checked')) {
											var id = $(this).attr("id");
											rselected.push(id);
											// alert(rselected);
											$("#" + id + "-hidden")
													.removeClass("hide");
										} else {
											rselected.pop();
										}
										// rselected.splice(this.indexOf(id),)

									});
					/**
					 * everytime the cbxSelectAllItems is selected, all rows in
					 * the same table should be selected.
					 */
					$("#cbxSelectAllItems").live('click', function(event) {
						if ($(this).attr("checked") == "checked") {
							$("table.recordTable tbody tr").each(function() {
								$(this).addClass("selected");
								$(":checkbox", $(this)).attr('checked', true);
							});
						} else {
							$("table.recordTable tbody tr").each(function() {
								$(this).removeClass("selected");
								$(":checkbox", this).attr('checked', false);
							});
						}
					});

					/**
					 * Scroll Bar
					 */
					/* zebra stripe the tables (not necessary for scrolling) */
					var tbl = $("table.recordTable");
					addZebraStripe(tbl);
					addMouseOver(tbl);

					function addZebraStripe(table) {
						table.find("tbody tr").not(".hidden-child-row").filter(
								":odd").addClass("alt");
					}

					function addMouseOver(table) {
						table.find("tbody tr").hover(function() {
							$(this).addClass("over");
						}, function() {
							$(this).removeClass("over");
						});
					}
					$("a").click(function(event) {
						var contentId = jQuery(this).attr("id");
						if (contentId.indexOf("lnkAdd") >= 0){
							
						} else {
							if (rselected.length > 0){
								$(this).appendAttr("href", rselected);
							}
							else {
								alert("No Item selected, please select one and try again!");
								var oldURL = document.referrer;
								$(this).attr("href", oldURL);
								//window.history.back();
								
							}
						}

					});

					// ===============================================================================================
					// ===============================================================================================

					// Adding string to url
					$.fn.appendAttr = function(attrName, suffix) {
						this.attr(attrName, function(i, val) {
							return val + suffix;
						});
						return this;
					};
					
					function endsWith(str, suffix) {
					    return str.indexOf(suffix, str.length - suffix.length) !== -1;
					}
					
					/**
					 * this method handles link/button clicks that require only one item in the
					 * record table to be selected
					 * 
					 * @param id
					 * @returns {Boolean}
					 */
					function getSingleSelectedItem(btnId, itemName) {
						alert();
						if (itemName == null || itemName == "")
							itemName = "item";

						if ($(":checked", "table.recordTable tbody tr").length > 0) {
							var id = $("input[name=selected" + itemName + "]:checked").map(
									function() {
										return this.value;
									}).get().join(",");
							if (id.indexOf(",") != -1) {
								return "multiple";
							}
							
							return id;

						} else
							
							return "none";

					}

					/**
					 * this method handles link and button clicks that require a one or more items
					 * in the record table to be selected
					 * 
					 * @param id
					 * @returns {Boolean}
					 */
					function multipleItemAction(btnId, itemName) {
						alert();
						if (itemName == null || itemName == "")
							itemName = "item";

						if ($(":checked", "table.recordTable tbody tr").length > 0) {
							if (window.confirm("Do you want to delete the selected " + itemName
									+ "(s)?")) {
								var ids = $("input[name=selected" + itemName + "]:checked").map(
										function() {
											return this.value;
										}).get().join(",");
								var href = $("#" + btnId).attr("href");
								href = href + ids;
								$("#" + btnId).attr("href", href);

								return true;
							}
						} else {
							alert("Please select " + itemName + "(s) and try again")
						}

						return false;

					}
					
					$("#btnSaveClient").live("click",function(event){
						var premium = $("#mPremium").val();
						//alert(premium);
						if(isNaN(premium) == true)
							return false;
							
					});
					
					$("a.redText").live("click",function(){
						var r = confirm("Do you want to delete item(s) selected");
						if (r == false)
							return false;
					});

				});
