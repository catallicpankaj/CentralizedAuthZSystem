Query H2-Console
-----------------
SELECT PERMISSION_ID , CAN_CREATE , CAN_READ , CAN_UPDATE , CAN_DELETE  FROM PERMISSIONS 


AddPermissions
------

curl --location 'http://localhost:8080/digital-auth/central-authz/v1/permissions' \ <br>
--header 'Content-Type: application/json' \ <br>
--data '{ <br>
    "permissionId":"1111", <br>
    "canCreate":true, <br>
    "canRead":true, <br>
    "canUpdate":true, <br>
    "canDelete":true <br>
}'