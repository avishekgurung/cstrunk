i=42
while [ $i -le 80  ]
do
	src="P"$i".java";
	echo "Copying: "$src;
	cp ../nodes/operations/$src .
	i=`expr $i + 1`
done

sh configure.sh

i=42
while [ $i -le 80  ]
do
        src="P"$i".java";
        echo "Removing: "$src;
	sudo rm -f $src
        i=`expr $i + 1`

done

chmod 777 *
