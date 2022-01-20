# jms-lab-p2p
JMS P2P example with ActiveMQ security settings 


# security

To security settings work, you need to change the files below on ActiveMQ

**file: <root_path>\artemis-broker\etc\artemis-user.properties**

- clinicaluser = clinicalpass
- eligibilityuser = eligibilitypass

**file: <root_path>\artemis-broker\etc\artemis-user.properties**

- clinicalrole = clinicaluser
- eligibilityrole = eligibilityuser

**file: <root_path>\artemis-broker\etc\artemis-user.properties**


	<security-setting match="borba.queues.request.#">
	    <permission type="createNonDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="deleteNonDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="createDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="deleteDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="createAddress" roles="clinicalrole,eligibilityrole"/>
	    <permission type="deleteAddress" roles="clinicalrole,eligibilityrole"/>
	    <permission type="consume" roles="eligibilityrole"/>
	    <permission type="browse" roles="clinicalrole"/>
	    <permission type="send" roles="clinicalrole"/>
	    <!-- we need this otherwise ./artemis data imp wouldn't work -->
	    <permission type="manage" roles="amq"/>
	 </security-setting>
	 <security-setting match="borba.queues.reply.#">
	    <permission type="createNonDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="deleteNonDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="createDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="deleteDurableQueue" roles="clinicalrole,eligibilityrole"/>
	    <permission type="createAddress" roles="clinicalrole,eligibilityrole"/>
	    <permission type="deleteAddress" roles="clinicalrole,eligibilityrole"/>
	    <permission type="consume" roles="clinicalrole"/>
	    <permission type="browse" roles="eligibilityrole"/>
	    <permission type="send" roles="eligibilityrole"/>
	    <!-- we need this otherwise ./artemis data imp wouldn't work -->
	    <permission type="manage" roles="amq"/>
	 </security-setting>

