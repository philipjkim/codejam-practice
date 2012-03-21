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

	lines = File.open(in_filename).read.split("\n")
	lines.length.times do |line_number|
		puts "Line #{line_number}: #{lines[line_number]}"
	end
end
