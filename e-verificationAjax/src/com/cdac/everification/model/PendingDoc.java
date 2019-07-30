package com.cdac.everification.model;

public class PendingDoc {

		private String candiFname;
		private String docType;
		public PendingDoc() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PendingDoc(String candiFname, String docType) {
			super();
			this.candiFname = candiFname;
			this.docType = docType;
		}
		public String getCandiFname() {
			return candiFname;
		}
		public void setCandiFname(String candiFname) {
			this.candiFname = candiFname;
		}
		public String getDocType() {
			return docType;
		}
		public void setDocType(String docType) {
			this.docType = docType;
		}
		@Override
		public String toString() {
			return "PendingDoc [candiFname=" + candiFname + ", docType=" + docType + "]";
		}
		
}
