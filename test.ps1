echo 'http://localhost:8080/user/getName/1'
$response = Invoke-RestMethod 'http://localhost:8080/user/getName/1' -Method 'GET' -Headers $headers
$response | ConvertTo-Json
echo '----'
echo 'http://localhost:8080/user/search/age/20'
$response = Invoke-RestMethod 'http://localhost:8080/user/search/age/20' -Method 'GET' -Headers $headers
$response | ConvertTo-Json
