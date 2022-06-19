echo '开始请求:'
$getUser = 'http://localhost:8080/user/get/1'
echo $getUser
$response = Invoke-RestMethod $getUser -Method 'GET' -Headers $headers
$response | ConvertTo-Json
echo '----'
$getName = 'http://localhost:8080/user/getName/1'
$response = Invoke-RestMethod $getName -Method 'GET' -Headers $headers
$response | ConvertTo-Json
echo '----'
$search = 'http://localhost:8080/user/search/age/18'
echo $search
$response = Invoke-RestMethod $search -Method 'GET' -Headers $headers
$response | ConvertTo-Json
