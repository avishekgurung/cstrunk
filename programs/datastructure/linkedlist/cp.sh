i=1 
while [ $i -le 31  ]
do
	src="P"$i".java";
	echo $src;
	cp ../nodes/operations/$src .
	i=`expr $i + 1`
done
