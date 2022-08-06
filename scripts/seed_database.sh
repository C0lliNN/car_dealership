echo "Cleaning database..."
mvn --quiet flyway:clean > /dev/null

echo "Running migrations..."
mvn --quiet flyway:migrate > /dev/null

echo "Inserting data..."
PGPASSWORD=postgres psql -h localhost -U postgres -d car_dealership -f scripts/seed_data.sql > /dev/null