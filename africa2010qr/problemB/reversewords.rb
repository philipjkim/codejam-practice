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
	out_file = File.open(out_filename, 'w')

	lines = File.open(in_filename).read.split("\n")
	1.upto(lines.length - 1) do |index|
		words = lines[index].split(" ")
		out_file.puts "Case ##{index}: #{words.reverse.join(" ")}"
	end
	puts Time.now - started
end
