echo "------------------------------------------------------------"
echo "Starting build and push everything.."

cd ../config-service
echo "------------------------------"
echo "Building config image..."
docker build -t cubepixels/cubidshop-config-service .
docker tag cubepixels/cubidshop-config-service cubepixels/cubidshop-config-service
docker push cubepixels/cubidshop-config-service
echo "done"

cd ../discovery-service
echo "------------------------------"
echo "Building discovery image..."
docker build -t cubepixels/cubidshop-discovery-service .
docker tag cubepixels/cubidshop-discovery-service cubepixels/cubidshop-discovery-service
docker push cubepixels/cubidshop-discovery-service
echo "done"

cd ../gateway-service
echo "------------------------------"
echo "Building gateway image..."
docker build -t cubepixels/cubidshop-gateway-service .
docker tag cubepixels/cubidshop-gateway-service cubepixels/cubidshop-gateway-service
docker push cubepixels/cubidshop-gateway-service
echo "done"

cd ../product-service
echo "------------------------------"
echo "Building product image..."
docker build -t cubepixels/cubidshop-product-service .
docker tag cubepixels/cubidshop-product-service cubepixels/cubidshop-product-service
docker push cubepixels/cubidshop-product-service
echo "done"

cd ../user-service
echo "------------------------------"
echo "Building user image..."
docker build -t cubepixels/cubidshop-user-service .
docker tag cubepixels/cubidshop-user-service cubepixels/cubidshop-user-service
docker push cubepixels/cubidshop-user-service
echo "done"

echo "Build and push of everything successfully"
echo "------------------------------------------------------------"