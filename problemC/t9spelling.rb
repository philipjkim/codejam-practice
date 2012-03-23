#!/usr/bin/env ruby

if __FILE__ == $0
	unless ARGV.length == 1
		puts "Usage: #{$0} input_filename"
		exit
	end
	in_filename = ARGV[0]
	unless File.exist?(in_filename)
		puts "File not exist: #{in_filename}"
		exit
	end

	started = Time.now

	out_filename = in_filename.split(".").first + ".out"
	#out_file = File.open(out_filename, 'w')

	rawhash = [["abc","2"], ["def","3"], ["ghi","4"], ["jkl","5"],
				["mno","6"], ["pqrs","7"], ["tuv","8"], ["wxyz","9"],
				[" ","0"]] 
	keyhash = {}
	rawhash.each do |chars, numkey|
		chars.length.times do |idx|
			keyhash[chars[idx]] = numkey * (idx + 1)
		end
	end
	puts keyhash

	lines = File.open(in_filename).read.split("\n")
	2.upto(lines.length - 1) do |index|
		lines[index].split("").each do |char|
		# do something.	
		end
		puts "Case ##{index}: #{lines[index]}"
	end
	puts Time.now - started
end
