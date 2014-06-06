rm -f mapping.txt
COUNT=1

echo "Creating Mapping File ..."
#create a mapping file
while read line
do
	INDEX=`echo $line | cut -d'.' -f1`
	echo $INDEX"\tP"$COUNT >> mapping.txt
	COUNT=$((COUNT+1))

done < index.txt

echo "Replacing Program Name ..."
#replace the program name and put in the temp file
while read line
do
	org=`echo $line | cut -d' ' -f1`	
	new=`echo $line | cut -d' ' -f2`
	gawk -v org_f=$org -v new_f=$new -F" " '{ gsub(org_f,new_f); print $0;}' $org".java" > $org"_temp.java"

done < mapping.txt


echo "Moving temporary file ..."
#move the temp file to the proper file
while read line
do
	org=`echo $line | cut -d' ' -f1`
	new=`echo $line | cut -d' ' -f2`
	mv $org"_temp.java" $new".java"
done < mapping.txt


echo "Generating index file ..."
#change the index file
gawk -F" " 'BEGIN{i = 1;}{p_no="P"i"."; gsub($1,p_no,$1);i++; print $0}' index.txt > temp.txt
mv temp.txt index.txt

rm -f mapping.txt
